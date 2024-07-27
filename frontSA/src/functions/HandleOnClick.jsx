export function handleOnClick(e, link, navigate) {
    e.preventDefault()
    navigate(link)
}

/*  1. importe:
        import { useNavigate } from 'react-router-dom'
        import { handleOnClick } from '../../functions/HandleOnClick'
        
    2. antes dos html no return, e dentro da function da sua página, ponha:
        const navigate = useNavigate()

    3. e use esta chamada de função para usá-lo :
        onClick={(e) => handleOnClick(e, '/qualidade/quantidade-erros', navigate)}
*/
