import { useContext, useEffect, useState } from "react";
import { ServiceCtx } from "../../contexts/indusphere/Service";
import "../../styles/pages/monitoramentoMaquinas/home.css";
import Gauge from "../../components/monitoramentoMaquinas/Gauge";
import GrafLinha from "../../components/monitoramentoMaquinas/GrafLinha";
import Pizza from "../../components/monitoramentoMaquinas/Pizza";
import GrafColunas from "../../components/monitoramentoMaquinas/GrafCoulnas";
import ProgressBar from "../../components/monitoramentoMaquinas/ProgressBar";
import Filtros from "../../components/monitoramentoMaquinas/Filtros";

export default function HomeMM() {
    const service = useContext(ServiceCtx);
    const [disponibilidade, setDisponibilidade] = useState(25);
    const [performance, setPerformance] = useState(100);
    const [qualidade, setQualidade] = useState(80);
    const [oees, setOees] = useState({ media: null, oees: [0] });

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

    const somaOee = (arr) => {
        let somatorio = 0;
        arr.forEach((element) => {
            somatorio += element;
        });
        return somatorio;
    };

    useEffect(() => {
        const interval = setInterval(() => {
            setDisponibilidade(Math.floor(Math.random() * 50) + 50);
            setPerformance(Math.floor(Math.random() * 50) + 50);
            setQualidade(Math.floor(Math.random() * 50) + 50);
        }, 10000);

        return () => clearInterval(interval);
    }, []);

    useEffect(() => {
        const newOee = parseInt((disponibilidade * performance * qualidade) / 10000);
        setOees((prev) => {
            const newOees = [...prev.oees, newOee];
            const newMedia = somaOee(newOees) / newOees.length;
            return { media: parseInt(newMedia), oees: newOees };
        });
    }, [disponibilidade, performance, qualidade]);

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
                        <Gauge num={parseInt((disponibilidade * performance * qualidade) / 10000)} />
                    </div>
                    <div className="metric">
                        <h3>Disponibilidade</h3>
                        <Gauge num={disponibilidade} />
                    </div>
                    <div className="metric">
                        <h3>Performance</h3>
                        <Gauge num={performance} />
                    </div>
                    <div className="metric">
                        <h3>Qualidade</h3>
                        <Gauge num={qualidade} />
                    </div>
                </div>
                <div className="charts">
                    <div className="chart chart-small">
                        <h3>OEE medio por Dia</h3>
                        <GrafLinha
                            oees={[
                                49,
                                33,
                                25,
                                40,
                                oees.media ?? 0,
                            ]}
                            dias={["Seg", "Ter", "Qua", "Qui", "Sex"]}
                        />
                    </div>
                    <div className="chart chart-small">
                        <h3>Tempo das Máquinas</h3>
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
