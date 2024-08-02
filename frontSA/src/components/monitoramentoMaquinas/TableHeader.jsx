import React from "react";
import AddMaquina from "./AddMaquina";

export default function TableHeader({ nomeTabela }) {
  return (
    <div
      style={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '0 2%',
        width: "96%",
        height: 60,
        borderTopLeftRadius: 8,
        borderTopRightRadius: 8,
        backgroundColor: '#333',
        color: '#fff'
      }}
    >
        {nomeTabela}
        <AddMaquina/>
    </div>
  );
}
