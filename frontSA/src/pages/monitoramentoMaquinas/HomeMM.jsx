import { useContext, useEffect, useState } from 'react'
import { ServiceCtx } from '../../contexts/indusphere/Service'
import * as StompJs from '@stomp/stompjs';
import '../../styles/pages/monitoramentoMaquinas/home.css'
import Gauge from '../../components/monitoramentoMaquinas/Gauge';
import GrafLinha from '../../components/monitoramentoMaquinas/GrafLinha';


export default function HomeMM() {
    const service = useContext(ServiceCtx)
    const [stompClient, setStompClient] = useState(null);
    const [connected, setConnected] = useState(false);
    const [greetings, setGreetings] = useState([]);
    const [contador, setcontador] = useState(0);


    useEffect(() => {
        service.setSrcLogo('/equipes/monitor.png')
        service.setPages([
            {
                label: 'Geral',
                rota: 'monitoramento-maquinas/geral'
            },
            {
                label: 'Kpi-Maquinas',
                rota: 'monitoramento-maquinas/kpi-maquinas'
            },
            {
                label: 'Cadastros',
                rota: 'monitoramento-maquinas/cadastros'
            }
        ])
    }, [])

    useEffect(() => {
        const client = new StompJs.Client({
            brokerURL: 'ws://localhost:8080/gs-guide-websocket',
            reconnectDelay: 5000,
            heartbeatIncoming: 4000,
            heartbeatOutgoing: 4000,
        });

        client.onConnect = () => {
            setConnected(true);
            console.log('Connected');
            client.subscribe('/topic/greetings', (message) => {
                const content = JSON.parse(message.body).content;
                setcontador(content);
                showGreeting(content);
            });
        };

        client.onStompError = (frame) => {
            console.error('Broker reported error: ' + frame.headers['message']);
            console.error('Additional details: ' + frame.body);
        };

        client.activate();
        setStompClient(client);

        return () => {
            if (client) client.deactivate();
        };
    }, []);


    const showGreeting = (message) => {
        setGreetings((prevGreetings) => [...prevGreetings, message]);
    };

    const connect = () => {
        if (stompClient) stompClient.activate();
    };

    const disconnect = () => {
        if (stompClient) stompClient.deactivate();
        setConnected(false);
        console.log('Disconnected');
    };

    return (
        <div style={{
            width: '100%',
            maxHeight: '100%',
            overflow: 'auto'
        }}> 
            <div className="filter-container">
                <select id="center">
                <option value="generalFactory">Centro de Trabalho: Geral Fábrica</option>
                </select>
                <select id="shift">
                <option value="firstShift">Turno: 1º turno</option>
                </select>
                <select id="period">
                <option value="currentWeek">Período: 01/02/2024 - 08/02/2024</option>
                </select>
            </div>
            <div >
                <div className="dashboard">
                <h2>Dashboard Máquinas</h2>
                <p>Qtd. produzida / Qtd. planejada</p>
                <div className="progress">
                    <div className="progress-bar" style={{width: '35%'}} />
                </div>
                <p>1.670 / 4.750</p>
                </div>
                <div className="metrics">
                <div className="metric">
                    <h3>OEE</h3>
                    <Gauge num={3}/>
                </div>
                <div className="metric">
                    <h3>Disponibilidade</h3>
                    <Gauge num={25}/>
                </div>
                <div className="metric">
                    <h3>Performance</h3>
                    <Gauge num={100}/>
                </div>
                <div className="metric">
                    <h3>Qualidade</h3>
                    <Gauge num={80}/>
                </div>
                </div>
                <div className="charts">
                <div className="chart chart-small">
                    <h3>OEE por Dia</h3>
                    <GrafLinha oees={[10, 41, 35, 51, 49, 62, 69, 91, 100]} dias={['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep']}/>
                </div>
                <div className="chart chart-small">
                    <h3>Timeline Máquinas</h3>
                    <canvas id="lineChart" />
                </div>
                <div className="chart chart-small">
                    <h3>Motivos de parada</h3>
                    <canvas id="downtimeChart" />
                </div>
                </div>
            </div>
            <div id="notificationsSidebar" className="notifications-sidebar">
                <h2>Notificações</h2>
                <div className="notification">
                <p>Não há notificações no momento.</p>
                </div>
            </div>
        </div>

    )
}
