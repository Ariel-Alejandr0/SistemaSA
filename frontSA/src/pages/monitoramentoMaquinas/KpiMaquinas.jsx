import React, { useContext, useEffect } from "react";
import { ServiceCtx } from "../../contexts/indusphere/Service";
import CardKpi from "../../components/monitoramentoMaquinas/CardKpi";

export default function KpiMaquinas() {
    const service = useContext(ServiceCtx);

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

    const dataProvisoria = [
        {
            nomeMaquina: 'Tear 1',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PARADA ',
            op: '000100235',
            produto: 'Camisa UltraPolo'
        },
        {
            nomeMaquina: 'Tear 2',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PRODUZINDO',
            op: '000100235',
            produto: 'Camisa UltraPolo',
        },
        {
            nomeMaquina: 'Tear 3',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PRODUZINDO',
            op: '000100235',
            produto: 'Camisa UltraPolo'
        },
        {
            nomeMaquina: 'Tear 4',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PRODUZINDO',
            op: '000100235',
            produto: 'Camisa UltraPolo'
        },
        {
            nomeMaquina: 'Tear 5',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PRODUZINDO',
            op: '000100235',
            produto: 'Camisa UltraPolo'
        },
        {
            nomeMaquina: 'Tear 6',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PRODUZINDO',
            op: '000100235',
            produto: 'Camisa UltraPolo'
        },
        {
            nomeMaquina: 'Tear 7',
            oee: 35,
            prodAtual: 2112,
            prodPrevisto: 4050,
            status: 'PARADA',
            op: '000100235',
            produto: 'Camisa UltraPolo'
        }
    ]

    return (
        <div
            style={{
                display: "flex",
                flexWrap: 'wrap',
                overflow: 'auto',
                justifyContent: "space-around",
                alignItems: "flex-start",
                height: "100%",
                width: "100%",
            }}
        >
            {
                dataProvisoria.map(i => <CardKpi
                    key={i.nomeMaquina}
                    nomeMaquina={i.nomeMaquina}
                    oee={i.oee}
                    prodAtual={i.prodAtual}
                    prodPrevisto={i.prodPrevisto}
                    status={i.status}
                    produto={i.produto}
                    op={i.op}
                />)
            }
        </div>
    );
}
