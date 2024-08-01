import React, { useState } from 'react';
import Handsontable from 'handsontable';
import { HotTable } from '@handsontable/react';
import 'handsontable/dist/handsontable.full.css';
import TableHeader from '../../components/monitoramentoMaquinas/TableHeader';

export default function CadastroMaquinas() {
  // Dados da tabela
  const [data, setData] = useState([
    ['Máquina 1', '001', '2023-01-15', 'Setor A', 'user123', '2024-03-12'],
    ['Máquina 2', '002', '2022-08-20', 'Setor B', 'user456', '2024-05-22'],
    // Adicione mais linhas conforme necessário
  ]);

  // Colunas da tabela
  const columns = [
    { title: 'Name', data: 0 },
    { title: 'ID Tipo Máquina', data: 1 },
    { title: 'Data Instalação', data: 2 },
    { title: 'Setor', data: 3 },
    { title: 'ID Usuário', data: 4 },
    { title: 'Última Manutenção', data: 5 },
  ];

  // Configuração das colunas
  const colHeaders = columns.map(col => col.title);
  const columnsConfig = columns.map(col => ({ data: col.data }));

  return (
    <div style={{
      display: 'flex',
      flexDirection: 'column',
      overflow: 'auto',
      width: '100%',
      height: '100%',
      boxSizing: 'border-box'
    }}>
      <TableHeader nomeTabela={'Maquinas'}/>
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
