import React, { useContext, useEffect } from 'react'
import { ServiceCtx } from '../../contexts/indusphere/Service'

export default function VerficiarEstoqueProduto() {
  const service = useContext(ServiceCtx)

  useEffect(() => {
    service.setSrcLogo('/equipes/monitor.png')
    service.setPages([
      {
          label: 'verficar estoque',
          rota: 'controle-estoque/verificar-estoque-produto'
      },
      {
          label: 'adicionar produto',
          rota: 'controle-estoque/adicionar-produto'
      }
    ])
  }, [])
  return (
    <div>
        verficar estoque
    </div>
  )
}
