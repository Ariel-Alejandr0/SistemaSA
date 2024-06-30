import { Routes, Route } from "react-router-dom"
import Home from "../pages/indusphere/Home"
import Private from "../pages/Private"
import RequireAuth from "../contexts/indusphere/RequireAuth"
import Login from "../pages/indusphere/Login"
import HomeMM from "../pages/monitoramentoMaquinas/HomeMM"

export default function Rotas() {
  return (
    <Routes>
        <Route path="/login" element={<Login/>}></Route>
        <Route element={<RequireAuth/>}>
          <Route path="/" element={<Home/>}/>
          <Route path="/private" element={<Private/>}/>
          <Route path='/controle-estoque' element={<Private/>}>

          </Route>
          <Route path='/monitoramento-maquinas' element={<HomeMM/>}>
            <Route path="home" element={<HomeMM/>}/>
            <Route path="kpi-maquinas" element={<></>}/>
            <Route path="cadastros" element={<></>}/>
          </Route>
          <Route path='/rastreio-rfid' element={<Private/>}>

          </Route>
          <Route path='/impressora-3d' element={<Private/>}>

          </Route>
          <Route path='/inventario' element={<Private/>}>

          </Route>
          <Route path='/qualidade' element={<Private/>}>

          </Route>
          <Route path="/gestao" element={<Private/>}>

          </Route>
        </Route>
    </Routes>
  )
}
