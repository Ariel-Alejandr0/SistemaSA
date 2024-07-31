import { Routes, Route, Outlet } from "react-router-dom"
import Home from "../pages/indusphere/Home"
import Private from "../pages/Private"
import RequireAuth from "../contexts/indusphere/RequireAuth"
import Login from "../pages/indusphere/Login"
import AdicionarProduto from "../pages/controleEstoque/AdicionarProduto"
import GeralMM from "../pages/monitoramentoMaquinas/GeralMM"
import KpiMaquinas from "../pages/monitoramentoMaquinas/KpiMaquinas"
import CadastroMaquinas from "../pages/monitoramentoMaquinas/CadastroMaquinas"
import VerficiarEstoqueProduto from "../pages/controleEstoque/VerficiarEstoqueProduto"
import ServicosRastreamento from "../pages/rastreioRFID/ServicosRastreamento"
import Servicos3D from "../pages/impressora3D/Servicos3D"
import ControleQualidade from "../pages/controleQualidade/ControleQualidade"
import QuantidadeErros from "../pages/controleQualidade/relatorios/QuantidadeErros"
import ListarErros from "../pages/controleQualidade/relatorios/ListarErros"
import Pedido from "../pages/gestao/pedido"


export default function Rotas() {
  return (
    <Routes>
        <Route path="/login" element={<Login/>}></Route>
        <Route element={<RequireAuth/>}>
          <Route path="/" element={<Home/>}/>
          <Route path="/private" element={<Private/>}/>
          <Route path='/controle-estoque' element={<Outlet/>}>
            <Route path='verificar-estoque-produto' element={<VerficiarEstoqueProduto/>}/>
            <Route path='adicionar-produto' element={<AdicionarProduto/>}/>
          </Route>
          <Route path='/monitoramento-maquinas' element={<Outlet/>}>
            <Route path="geral" element={<GeralMM/>}/>
            <Route path="kpi-maquinas" element={<KpiMaquinas/>}/>
            <Route path="cadastros" element={<CadastroMaquinas/>}/>
          </Route>
          <Route path='/rastreio-rfid' element={<Outlet/>}>
            <Route path="servicos-rastreamento" element={<ServicosRastreamento/>}>
              
            </Route>
          </Route>
          <Route path='/impressora-3d' element={<Outlet/>}>
            <Route path="servicos-3d" element={<Servicos3D/>}/>
          </Route> 
          <Route path='/inventario' element={<Outlet/>}>

          </Route>
          <Route path='/qualidade' element={<Outlet/>}>
            <Route path='home-qualidade' element={<ControleQualidade/>}/>
            <Route path='quantidade-erros' element={<QuantidadeErros/>}/>
            <Route path='listar-erros' element={<ListarErros/>}/>
          </Route>

          <Route path="/gestao" element={<Outlet/>}>
            <Route path='pedido' element={<Pedido/>}/>
          </Route>
        </Route>
    </Routes>
  )
}
