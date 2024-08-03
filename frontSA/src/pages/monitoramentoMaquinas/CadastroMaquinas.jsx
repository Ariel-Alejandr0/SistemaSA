import React, { useEffect, useState } from "react";
import Handsontable from "handsontable";
import { HotTable } from "@handsontable/react";
import "handsontable/dist/handsontable.full.css";
import TableHeader from "../../components/monitoramentoMaquinas/TableHeader";
import axios from "axios";

export default function CadastroMaquinas() {
    // Dados da tabela
    const [dataTabela, setDataTabela] = useState([]);
    const [data, setData] = useState([
        ["Máquina 1", "001", "2023-01-15", "Setor A", "user123", "2024-03-12"],
        ["Máquina 2", "002", "2022-08-20", "Setor B", "user456", "2024-05-22"],
        // Adicione mais linhas conforme necessário
    ]);

    // Colunas da tabela
    const columns = [
        { title: "id_machine", data: 0 },
        { title: "name_machine", data: 1 },
        { title: "ID Tipo Máquina", data: 2 },
        { title: "Data Instalação", data: 3 },
        { title: "Última Manutenção", data: 4},
        { title: "Setor", data: 5 },
        { title: "ID Usuário", data: 6 },
        { title: "Nome Usuário", data: 7 },
    ];

    // Configuração das colunas
    const colHeaders = columns.map((col) => col.title);
    const columnsConfig = columns.map((col) => ({ data: col.data }));

    useEffect(() => {
        async function getMaquinas() {
            const request = await axios.get("http://localhost:8080/auth/allMachines");
            if (request) {
                setData(
                    request.data.map((maquina) => [
                        maquina.id_machine,
                        maquina.name,
                        maquina.idTipoMaquina,
                        maquina.dataInstalacao,
                        maquina.ultimaManutencao,
                        maquina.setor,
                        maquina.usuario.id_usuario,
                        maquina.usuario.nome,
                    ])
                );
            }
        }
        getMaquinas()
    }, []);
    
    return (
        <div
            style={{
                display: "flex",
                flexDirection: "column",
                overflow: "auto",
                width: "100%",
                height: "100%",
                boxSizing: "border-box",
            }}
        >
            <TableHeader nomeTabela={"Maquinas"} />
            <HotTable
                data={data}
                colHeaders={colHeaders}
                columns={columnsConfig}
                rowHeaders={true}
                licenseKey="non-commercial-and-evaluation"
                width="100%"
                height="100%"
                stretchH="all"
            />
        </div>
    );
}
