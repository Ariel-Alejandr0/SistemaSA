import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080/auth',

})

export const useApi = () => ({
    validateToken: async (token) => {
        return {
            user: { id: 3, name: 'jo', email: 'jo@gmail.com' }
        }
        //const res = await api.post('/validate');
    },
    login: async (email, password) => {
        try {
            const res = await api.post('/login', { 
                email: email, 
                password: password 
            })
            return res.data;
        } catch (error) {
            console.error("Error logging in:", error);
            throw error;
        }
    },
    logout: () => {
        localStorage.removeItem('authToken')
        localStorage.removeItem('email')
        localStorage.removeItem('password')
    }
})