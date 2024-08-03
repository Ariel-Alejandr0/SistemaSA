import { useContext, useEffect, useState } from "react";
import { ServiceCtx } from "../../contexts/indusphere/Service";

export default function Home() {
    const [count, setCount] = useState(0);
    const service = useContext(ServiceCtx);

    useEffect(() => {
        service.setPages([
            {
                label: "Home",
                rota: "/",
            },
            {
                label: "Cadastro",
                rota: '/registro-usuario'
            },
        ]);
        service.setSrcLogo("/logoIndusphere.png");
    }, []);

    useEffect(() => {
    }, [service.srcLogo]);
    return (
        <>
            <h2>HOME</h2>
        </>
    );
}
