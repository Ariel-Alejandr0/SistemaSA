import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import { BrowserRouter } from 'react-router-dom'
import { AuthProvider } from './contexts/indusphere/Auth.jsx'
import { ServiceProvier } from './contexts/indusphere/Service.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <AuthProvider>
      <ServiceProvier>
        <BrowserRouter>
          <App />
        </BrowserRouter>
      </ServiceProvier>
    </AuthProvider>
  </React.StrictMode>,
)
