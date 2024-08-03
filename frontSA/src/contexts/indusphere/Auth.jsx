import { createContext, useContext, useEffect, useState } from "react";
import { useApi } from "../hooks/useApi";

export const AuthCtx = createContext(null)

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null)
    const api = useApi()

    useEffect(() => {
        const validateToken = async () => {
            const localEmail = localStorage.getItem('email')
            const localPassword = localStorage.getItem('password')
            if (localEmail && localPassword) {
                const data = await api.login(localEmail, localPassword)
                console.log(data)
                if(data){
                    setUser(data)
                }
            }
        }
        validateToken()
    }, [])

    const signin = async (email, password) => {
        const data =  await api.login(email, password);
        if(data) {
            setUser(data)
            localStorage.setItem('email', email)
            localStorage.setItem('password', password)
            return true
        } 
        return false
    }

    const signout = async () => {
        await api.logout()
        setUser(null)
        setToken('')
    }
    
    const setToken = (token) => {
        localStorage.setItem('authToken', token)
    }

    return(
        <AuthCtx.Provider value={{ signin, signout, user }}>
            {children}
        </AuthCtx.Provider>
    )
}
