import React, { useContext, useEffect } from 'react'
import { ServiceCtx } from '../../contexts/indusphere/Service'

export default function GeralMM() {
    const service = useContext(ServiceCtx)

    useEffect(() => {
        service.setSrcLogo('/equipes/monitor.png')
        service.setPages([
            {
                label: 'Geral',
                rota: 'monitoramento-maquinas/geral'
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
            <h2>Geral MONITAREMENTO MAQUINAS</h2>
        </div>
    )
}
