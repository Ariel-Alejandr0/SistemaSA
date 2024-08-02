import React, { useState } from "react";
import RegisterMachine from "./RegisterMachine";

export default function AddMaquina() {
    const [openForm, setOpenForm] = useState(false);
    const handleOnClick = () => {
        setOpenForm((prev) => !prev);
    };

    return (
        <div style={{ margin: 0 }}>
            <button
                onClick={handleOnClick}
                style={{
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    backgroundColor: "#555",
                    width: 120,
                    height: 35,
                    margin: 0,
                    fontSize: "normal",
                }}
            >
                + Adicionar Máquina
            </button>
            {openForm && (
                <>
                    <div
                        style={{
                            position: "fixed",
                            top: "50%",
                            left: "50%",
                            transform: "translate(-50%, -50%)",
                            zIndex: 1001,
                        }}
                    >
                        <RegisterMachine fehcarForm={handleOnClick}/>
                    </div>
                    <div
                        onClick={handleOnClick}
                        style={{
                            position: "fixed",
                            top: 0,
                            left: 0,
                            width: "100%",
                            height: "100%",
                            backgroundColor: "rgba(0, 0, 0, 0.5)",
                            zIndex: 1000,
                        }}
                    />
                </>
            )}
        </div>
    );
}
