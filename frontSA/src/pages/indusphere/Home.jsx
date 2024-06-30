import { useContext, useEffect, useState } from 'react'
import { ServiceCtx } from '../../contexts/indusphere/Service'

export default function Home() {
  
  const [count, setCount] = useState(0)
  const service = useContext(ServiceCtx)

  useEffect(() => {

      service.setPages([
        {
            label: 'Home',
            rota: '#home'
        },
        {
            label: 'Services',
            rota: '#services'
        },
        {
            label: 'About',
            rota: '#about'
        },
        {
            label: 'Contact',
            rota: '#contact'
        }   
    ])
    service.setSrcLogo('/logoIndusphere.png')
    
  }, [])
  
  useEffect(() => {
    console.log(service.srcLogo)
  }, [service.srcLogo])
  return (
    <>
      <h2>HOME</h2>
    </>
  )
}
