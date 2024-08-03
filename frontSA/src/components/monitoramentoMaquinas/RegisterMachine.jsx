import React, { useState, useContext } from "react";
import { AuthCtx } from "../../contexts/indusphere/Auth";
import axios from "axios";
import { tratandoErro } from "../../functions/tratandoErro";

const RegisterMachine = ({ fehcarForm }) => {
    const { user } = useContext(AuthCtx);
    const [machineData, setMachineData] = useState({
        name: "",
        idTipoMaquina: "",
        dataInstalacao: "",
        setor: "",
        idUsuario: "", // Preenchendo com o id_usuario do contexto de autenticação
        ultimaManutencao: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setMachineData((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post(
                "http://localhost:8080/auth/registerMachine",
                {
                    ...machineData,
                }
            );
            alert('Máquina registrada com sucesso')
        } catch (error) {
            console.error("Error registering machine:", error);
            tratandoErro(error)
        }
        fehcarForm();
    };

    return (
        <div
            style={{
                width: "40vw",
                height: "auto",
                padding: "4%",
                borderRadius: 12,
                border: "2px solid",
                backgroundColor: "#fff",
            }}
        >
            <form
                style={{
                    width: "100%",
                    height: "100%",
                    color: "black",
                }}
                onSubmit={handleSubmit}
            >
                <input
                    type="text"
                    name="name"
                    value={machineData.nome}
                    onChange={handleChange}
                    placeholder="Nome da Máquina"
                />
                <input
                    type="text"
                    name="idTipoMaquina"
                    value={machineData.idTipoMaquina}
                    onChange={handleChange}
                    placeholder="Tipo da Máquina"
                />
                <div
                    style={{
                        display: "flex",
                        width: "100%",
                        alignItems: "center",
                    }}
                >
                    <label>Data de instalação: </label>
                    <input
                        style={{ flex: 1 }}
                        type="date"
                        name="dataInstalacao"
                        value={machineData.dataInstalacao}
                        onChange={handleChange}
                        placeholder="Data de Instalação"
                    />
                </div>
                <input
                    type="text"
                    name="setor"
                    value={machineData.setor}
                    onChange={handleChange}
                    placeholder="Setor"
                />
                <input
                    type="text"
                    name="idUsuario"
                    value={machineData.idUsuario}
                    onChange={handleChange}
                    placeholder="ID Usuário"
                />
                <div
                    style={{
                        display: "flex",
                        width: "100%",
                        alignItems: "center",
                    }}
                >
                    <label>Última manutenção: </label>
                    <input
                        style={{ flex: 1 }}
                        type="date"
                        name="ultimaManutencao"
                        value={machineData.ultimaManutencao}
                        onChange={handleChange}
                        placeholder="Data da Última Manutenção"
                    />
                </div>
                <button type="submit">Registrar Máquina</button>
                <button onClick={fehcarForm}> fechar </button>
            </form>
        </div>
    );
};

export default RegisterMachine;
