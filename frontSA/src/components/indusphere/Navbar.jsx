import React, { useContext } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { AuthCtx } from '../../contexts/indusphere/Auth'
import '../../styles/components/indusphere/navbar.css'
import '../../styles/components/indusphere/profile.css'
import { ServiceCtx } from '../../contexts/indusphere/Service'

export default function Navbar() {

    const auth = useContext(AuthCtx)
    const services = useContext(ServiceCtx)  
    const navigate = useNavigate()
    return (
      <header>
        <div className="logo">
            <img src={services.srcLogo} width={100}  height={45} alt="Logo" />
        </div>
        <nav>
            <ul className="menu">
                {services.pages?.map(srv => (
                    <li key={srv.label} onClick={() => navigate(srv.rota)}> 
                        <a>
                            {srv.label} 
                        </a>
                    </li>
                ))}
            </ul>
        </nav>
        {/* <div className="user-icon">
            <img src="user.png" alt="User" />
        </div> */}
    </header>
    )
}
