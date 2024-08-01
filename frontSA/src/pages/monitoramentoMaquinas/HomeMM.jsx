import { useContext, useEffect, useState } from "react";
import { ServiceCtx } from "../../contexts/indusphere/Service";
import useWebSocket from "react-use-websocket";
import "../../styles/pages/monitoramentoMaquinas/home.css";
import Gauge from "../../components/monitoramentoMaquinas/Gauge";
import GrafLinha from "../../components/monitoramentoMaquinas/GrafLinha";
import Pizza from "../../components/monitoramentoMaquinas/Pizza";
import GrafColunas from "../../components/monitoramentoMaquinas/GrafCoulnas";
import ProgressBar from "../../components/monitoramentoMaquinas/ProgressBar";
import Filtros from "../../components/monitoramentoMaquinas/Filtros";

export default function HomeMM() {
    const service = useContext(ServiceCtx);
    // const [stompClient, setStompClient] = useState(null);
    // const [connected, setConnected] = useState(false);
    // const [greetings, setGreetings] = useState([]);
    // const [contador, setcontador] = useState(0);

    useEffect(() => {
        service.setSrcLogo("/equipes/monitor.png");
        service.setPages([
            {
                label: "Geral",
                rota: "monitoramento-maquinas/geral",
            },
            {
                label: "Kpi-Maquinas",
                rota: "monitoramento-maquinas/kpi-maquinas",
            },
            {
                label: "Cadastros",
                rota: "monitoramento-maquinas/cadastros",
            },
        ]);
    }, []);

    // useEffect(() => {
    //     const client = new StompJs.Client({
    //         brokerURL: "ws://localhost:8080/gs-guide-websocket",
    //         reconnectDelay: 5000,
    //         heartbeatIncoming: 4000,
    //         heartbeatOutgoing: 4000,
    //     });

    //     client.onConnect = () => {
    //         setConnected(true);
    //         console.log("Connected");
    //         client.subscribe("/topic/greetings", (message) => {
    //             const content = JSON.parse(message.body).content;
    //             setcontador(content);
    //             showGreeting(content);
    //         });
    //     };

    //     client.onStompError = (frame) => {
    //         console.error("Broker reported error: " + frame.headers["message"]);
    //         console.error("Additional details: " + frame.body);
    //     };

    //     client.activate();
    //     setStompClient(client);

    //     return () => {
    //         if (client) client.deactivate();
    //     };
    // }, []);

    // const showGreeting = (message) => {
    //     setGreetings((prevGreetings) => [...prevGreetings, message]);
    // };

    // const connect = () => {
    //     if (stompClient) stompClient.activate();
    // };

    // const disconnect = () => {
    //     if (stompClient) stompClient.deactivate();
    //     setConnected(false);
    //     console.log("Disconnected");
    // };

    return (
        <div
            style={{
                width: "100%",
                maxHeight: "100%",
                overflow: "auto",
            }}
        >
            <Filtros />
            <div>
                <div className="dashboard">
                    <h2>Dashboard Máquinas</h2>
                    <ProgressBar qtdProd={2000} qtdPlan={4350} />
                </div>
                <div className="metrics">
                    <div className="metric">
                        <h3>OEE</h3>
                        <Gauge num={3} />
                    </div>
                    <div className="metric">
                        <h3>Disponibilidade</h3>
                        <Gauge num={25} />
                    </div>
                    <div className="metric">
                        <h3>Performance</h3>
                        <Gauge num={100} />
                    </div>
                    <div className="metric">
                        <h3>Qualidade</h3>
                        <Gauge num={80} />
                    </div>
                </div>
                <div className="charts">
                    <div className="chart chart-small">
                        <h3>OEE por Dia</h3>
                        <GrafLinha
                            oees={[10, 41, 35, 51, 49, 62, 69, 91, 100]}
                            dias={[
                                "Jan",
                                "Feb",
                                "Mar",
                                "Apr",
                                "May",
                                "Jun",
                                "Jul",
                                "Aug",
                                "Sep",
                            ]}
                        />
                    </div>
                    <div className="chart chart-small">
                        <h3>Timeline Máquinas</h3>
                        <Pizza
                            series={[80, 18, 2]}
                            labels={["Produzindo", "Parada", "Desconectada"]}
                        />
                    </div>
                    <div className="chart chart-small">
                        <h3>Motivos de parada</h3>
                        <GrafColunas
                            data={[5, 1, 10, 1]}
                            categories={[
                                "Fio rompido",
                                "Em manutenção",
                                "Rolo concluído",
                                "Falha de Equipamento",
                            ]}
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}