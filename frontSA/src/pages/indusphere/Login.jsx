import React, { useContext, useEffect, useState } from 'react'
import { AuthCtx } from '../../contexts/indusphere/Auth'
import { useNavigate } from 'react-router-dom';
import '../../styles/pages/indusphere/login.css'


export default function Login() {
  const auth = useContext(AuthCtx);
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const navigate = useNavigate()

  const handleLogin = async (event) => {
    event.preventDefault();
    console.log(email, password)
    if(email && password) {
        await auth.signin(email, password)
    }
  }

  useEffect(() => {
    if(auth.user) navigate('/') 
  }, [auth.user])

  return (
    <div style={{display: 'flex', flexDirection: 'column', alignItems: 'center'}}>
        <div >
            <img src="/logoIndusphere.png" alt="Logo"/>
        </div>

        <div className="login-container">
            <form className="login-form">
                <h2>Login</h2>
                <div className="form-group">
                    <label>Nome</label>
                    <input 
                        type="text" 
                        id="username" 
                        name="username" 
                        required
                        value={email}
                        onChange={e => setEmail(e.target.value)}    
                    />
                </div>
                <div className="form-group">
                    <label>Senha</label>
                    <input 
                        type="password" 
                        id="password" 
                        name="password" 
                        required
                        value={password}
                        onChange={e => setPassword(e.target.value)}    
                    />
                </div>
                <div className="form-group">
                    <a href="#" className="forgot-password">Esqueci a minha senha</a>
                </div>
                    
                <button 
                    type="submit" 
                    className="login-btn"
                    onClick={handleLogin}
                >
                    Entrar
                </button>
            </form>
        </div>
    </div>
  )
}
