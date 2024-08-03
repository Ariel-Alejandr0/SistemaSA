import React, { useContext, useEffect, useState } from 'react'
import { AuthCtx } from "../../contexts/indusphere/Auth";
import { ServiceCtx } from '../../contexts/indusphere/Service'
import axios from "axios";
import { tratandoErro } from '../../functions/tratandoErro';

const RegistraUser = () => {
  const service = useContext(ServiceCtx)
  const { user } = useContext(AuthCtx);
  const [userData, setuserData] = useState({
    nome: "",
    email: "",
    idPapel: "",
    senha: "",
    idPessoa: "1",
    estado:"",
    cidade:"",
    bairro:"",
    logradouro:"",
    complemento:"",
    numero:"",
    cep:"",
  });


  const handleChange = (e) => {
    const { name, value } = e.target;
    setuserData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };


  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/auth/register",
        {
          ...userData,
        }
      );
      console.log(response);
    } catch (error) {
      console.error("Error registering user:", error);
      tratandoErro(error)
    }
  };
  return (
    <div>
      
      <form
        style={{
          width: "100%",
        }}
        onSubmit={handleSubmit}
      >
        <input
          type="text"
          name="nome"
          value={userData.nome}
          onChange={handleChange}
          placeholder="Nome do usuario"
        />
        <input
          type="text"
          name="email"
          value={userData.email}
          onChange={handleChange}
          placeholder="email"
        />

        <input
          type="text"
          name="idPapel"
          value={userData.idPapel}
          onChange={handleChange}   
          placeholder="papel"
        />
        <input
          type="text"
          name="senha"
          value={userData.senha}
          onChange={handleChange}
          placeholder="senha"
        />
        {/* <center><div><strong>ENDEREÇO</strong></div></center>
         <input
          type="text"
          name="estado"
          value={userData.estado}
          onChange={handleChange}
          placeholder="estado"
        />
        <input
          type="text"
          name="cidade"
          value={userData.cidade}
          onChange={handleChange}
          placeholder="cidade"
        />
        <input
          type="text"
          name="bairro"
          value={userData.bairro}
          onChange={handleChange}
          placeholder="bairro"
        />
        <input
          type="text"
          name="logradouro"
          value={userData.logradouro}
          onChange={handleChange}
          placeholder="logradouro"
        />
        <input
          type="text"
          name="complemento"
          value={userData.complemento}
          onChange={handleChange}
          placeholder="complemento"
        />
        <input
          type="text"
          name="numero"
          value={userData.numero}
          onChange={handleChange}
          placeholder="numero"
        />
        <input
          type="text"
          name="cep"
          value={userData.cep}
          onChange={handleChange}
          placeholder="cep"
        />  */}
                
        <button type="submit">Registrar usuario</button>
      </form>
    </div>
  );
};
export default RegistraUser;