import React, { useContext, useEffect } from 'react'
import { ServiceCtx } from '../../contexts/indusphere/Service'

export default function HomeMM() {
    const service = useContext(ServiceCtx)

    useEffect(() => {
        service.setSrcLogo('/equipes/monitor.png')
        service.setPages([
            {
                label: 'Home',
                rota: 'monitoramento-maquinas/home'
            },
            {
                label: 'Kpi-Maquinas',
                rota: 'monitoramento-maquinas/kpi-maquinas'
            },
            {
                label: 'Cadastros',
                rota: 'monitoramento-maquinas/cadastros'
            }
        ])
    }, [])

    return (
        <div>
            <h2>HOME MONITAREMENTO MAQUINAS</h2>
        </div>
    )
}
