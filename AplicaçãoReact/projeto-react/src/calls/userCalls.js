import ApiCalls from './apiCalls'

class UsuarioCalls extends ApiCalls{

    constructor() {
        super('/user')
    }

    autenticar(credentials) {
        return this.post('/login', credentials);
    }

    sair() {
        return this.get('/logoff')
    }

}
export default UsuarioCalls