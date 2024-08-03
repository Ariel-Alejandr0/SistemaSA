import React, { useContext, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { ServiceCtx } from '../../contexts/indusphere/Service'

export default function ListServicos() {
    const navigate = useNavigate()
    const serviceFuntions = useContext(ServiceCtx)
    
    const DATA = [
        {
            name: 'Registro de usuarios',
            rota: '/', // Corrigido
            src: '/equipes/registro-usuario.png'   
        },
        {
            name: 'Controle de Estoque',
            rota: '/controle-estoque/verificar-estoque-produto',
            src: '/equipes/box.png'
        },
        {
            name: 'Monitorament Maq',
            rota: '/monitoramento-maquinas/geral',
            src: '/equipes/monitor.png'
        },
        {
            name: 'Rastreio RFID',
            rota: '/rastreio-rfid/servicos-rastreamento',
            src: '/equipes/localizacao.png'
        },
        {
            name: 'Impressora 3D',
            rota: '/impressora-3d/servicos-3d',
            src: '/equipes/impressora-3d.png'
        },
        {
            name: 'Inventario',
            rota: '/inventario',
            src: '/equipes/inventario.png'
        },
        {
            name: 'Qualidade',
            rota: '/qualidade/home-qualidade',
            src: '/equipes/qualidade.png'
        },
        {
            name: 'Gestao',
            rota: '/gestao',
            src: '/equipes/gestao.png'
        },
    ]

    return (
        <ul id="side_items">
            {DATA.map(service => {
                let bg;
                if (serviceFuntions.serviceName === service.name) {
                    bg = '#4f46e5'
                } else {
                    bg = 'transparent'
                }
                
                return(
                    <div key={service.name} style={{ backgroundColor: bg, borderRadius: 8}}>
                        <li  
                            className="side-item" 
                            id={service.name}

                            onClick={() => {
                                navigate(service.rota)
                                serviceFuntions.setServiceName(service.name)
                            }}
                        >
                            
                            <span className="item-description">
                                {service.name}
                            </span>
                            <img src={service.src} alt={service.name} className="icon-image"/>
                        </li>
                    </div>
                )})
            }
        </ul>
    )
}