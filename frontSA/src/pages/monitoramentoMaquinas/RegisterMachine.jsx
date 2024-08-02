import React, { useState, useContext } from "react";
import { AuthCtx } from "../../contexts/indusphere/Auth";
import axios from "axios";

const RegisterMachine = () => {
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
            console.log(response);
        } catch (error) {
            console.error("Error registering machine:", error);
        }
    };

    return (
        <div
            style={{
                width: "40vw",
                height: "50vh",
                backgroundColor: 'blue',
            }}
        >
            <form
                style={{
                    width: "100%",
                    height: "100%",
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
                    placeholder="ID Tipo Máquina"
                />
                <input
                    type="date"
                    name="dataInstalacao"
                    value={machineData.dataInstalacao}
                    onChange={handleChange}
                    placeholder="Data de Instalação"
                />
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
                <input
                    type="date"
                    name="ultimaManutencao"
                    value={machineData.ultimaManutencao}
                    onChange={handleChange}
                    placeholder="Data da Última Manutenção"
                />
                <button type="submit">Registrar Máquina</button>
            </form>
        </div>
    );
};

export default RegisterMachine;
