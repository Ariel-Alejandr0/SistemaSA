import React, { useState } from 'react';
import './styles.css'; 
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function VerificarOMS() {
    const navigate = useNavigate()
    const [rows, setRows] = useState([]);

    const addRow = () => {
        const idManutencao = document.getElementById("idManutencao").value;
        const idMaquina = document.getElementById("idMaquina").value;
        const descricaoErro = document.getElementById("descricaoErro").value;
        const funcionario = document.getElementById("funcionario").value;
        const situacaoSelect = document.getElementById("situacao");
        const selectedSituacao = situacaoSelect.options[situacaoSelect.selectedIndex].text;
        const situacaoClass = situacaoSelect.value;

    
        setRows(prevRows => [
            ...prevRows,
            {
                idManutencao,
                idMaquina,
                descricaoErro,
                funcionario,
                situacao: selectedSituacao,
                situacaoClass 
            }
        ]);

        document.getElementById("idManutencao").value = "";
        document.getElementById("idMaquina").value = "";
        document.getElementById("descricaoErro").value = "";
        document.getElementById("funcionario").value = "";
        situacaoSelect.selectedIndex = 0;
    };

    const deleteRow = index => {
        const updatedRows = [...rows];
        updatedRows.splice(index, 1);
        setRows(updatedRows);
    };

    return (
        <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
        <div className="container">
            <header className = 'oms'>
                <h1>Verificar OMS (Ordem de Manutenção)</h1>
            </header>
            <table id="omsTable">
                <thead>
                    <tr>
                        <th>ID MANUTENÇÃO</th>
                        <th>ID MÁQUINA</th>
                        <th>DESCRIÇÃO ERRO</th>
                        <th>FUNCIONÁRIO</th>
                        <th>SITUAÇÃO</th>
                        <th>AÇÕES</th>
                    </tr>
                </thead>
                <tbody>
                    {}
                    {rows.map((row, index) => (
                        <tr key={index}>
                            <td>{row.idManutencao}</td>
                            <td>{row.idMaquina}</td>
                            <td>{row.descricaoErro}</td>
                            <td>{row.funcionario}</td>
                            <td className={row.situacaoClass}>{row.situacao}</td>
                            <td>
                                <button onClick={() => deleteRow(index)}>Remover</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="form-container">
                <input type="number" id="idManutencao" placeholder="ID Manutenção" />
                <input type="number" id="idMaquina" placeholder="ID Máquina" />
                <input type="text" id="descricaoErro" placeholder="Descrição Erro" />
                <input type="text" id="funcionario" placeholder="Funcionário" />
                <select id="situacao">
                    <option value="green">Concluído</option>
                    <option value="yellow">Em andamento</option>
                    <option value="red">Alerta</option>
                </select>
                <button className="add-button" onClick={addRow}>Adicionar</button>
            </div>
            <div className="legend">
                <p><span className="green"></span> Concluído</p>
                <p><span className="yellow"></span> Em andamento</p>
                <p><span className="red"></span> Alerta</p>
            </div>
            <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/servicos-3d', navigate)}>
      <p>Voltar</p>
    </div>
        </div>
        </div>
    );
}
