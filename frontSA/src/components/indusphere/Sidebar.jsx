import React, { useContext } from 'react'
import '../../styles/components/indusphere/sidebar.css'
import { faRightFromBracket } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import ListServicos from './ListServicos'
import { AuthCtx } from '../../contexts/indusphere/Auth'
import { useNavigate } from 'react-router-dom'


export default function Sidebar() {
    const auth = useContext(AuthCtx)
    const navigate = useNavigate()

    const handleLogout = async () => {
        const sair = auth.signout()
        if (sair) navigate('/login')
    }

    const handleOpenSidebar = () => {
        document.getElementById('sidebar').classList.toggle('open-sidebar')
    }

    return (
        <nav id='sidebar'>
    
        <div id="user">

            <p id="user_infos">
                <span className="item-description">
                    {auth.user?.name}
                </span>
                <span className="item-description">
                    {localStorage.getItem('email')}
                </span>
            </p>
            <img src="/equipes/perfil.png" id="user_avatar" alt="Avatar"/>
        </div>
        <div id="sidebar_content">
            
            <ListServicos/>

            <button id="open_btn" onClick={handleOpenSidebar}>
                <i id="open_btn_icon" className="fa-solid fa-chevron-right"></i>
            </button>
        </div>

        <div id="logout">
            <button id="logout_btn" onClick={handleLogout}>
                <FontAwesomeIcon icon={faRightFromBracket}/>
                <span className="item-description">
                    Logout
                </span>
            </button>
        </div>
    
        </nav>
    )
}
