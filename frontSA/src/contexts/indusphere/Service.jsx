import { createContext, useState } from "react";

export const ServiceCtx = createContext(null)

export const ServiceProvier = ({ children }) => {
    const [serviceName, setServiceName] = useState('')
    const [pages, setPages] = useState()
    const [srcLogo, setSrcLogo] = useState('/logoIndusphere.png')

    return (
        <ServiceCtx.Provider 
            value={{
                serviceName,
                pages,
                srcLogo,
                setServiceName,
                setPages,
                setSrcLogo
            }}
        >
            {children}
        </ServiceCtx.Provider>
    )
}