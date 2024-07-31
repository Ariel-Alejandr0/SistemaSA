import React, { useEffect, useState } from "react";
import '../../styles/components/monitoramentoMaquinas/cardKpi.css'
import Gauge from "./Gauge";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBox, faKey } from '@fortawesome/free-solid-svg-icons';

export default function CardKpi({ nomeMaquina, oee, status, prodAtual, prodPrevisto, produto, op}) {
    const [color, setColor] = useState('')

    useEffect(() => {
        if (status === 'PRODUZINDO')
            setColor('green')
        else    
            setColor('red')
    }, [status])

    return (
        <div className="machine-card producing" style={{borderColor: color}}>
            <h2>
                {nomeMaquina + " "} <span style={{color: color}}>{status}</span>
            </h2>
            <div className="machine-info">
                <div 
                    style={{
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'flex-start',
                        justifyContent: 'flex-start',
                        width: '100%'
                    }}
                >
                    <p>
                        <FontAwesomeIcon icon={faKey} /> Ordem de produção: {op}
                    </p>
                    <p>
                        <FontAwesomeIcon icon={faBox} /> Produto Atual: {produto}
                    </p>
                </div>
                <p>Qtd. produzida / Qtd. planejada</p>
                <div className="progress">
                    <div className="progress-bar" style={{ width: `${(prodAtual / prodPrevisto) * 100}%` }} />
                </div>
                <p>{prodAtual} / {prodPrevisto}</p>
                <div className="gauge">
                    <Gauge num={oee} />
                </div>
                <p><strong>OEE</strong></p>
            </div>
        </div>
    );
}
