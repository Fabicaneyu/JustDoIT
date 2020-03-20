import React from 'react'
import ImgBusca from '../imagens/lupa.png'

class Busca extends React.Component {

    state = {

        busca : ''

    }


    buscar = () => {
        console.log(this.state.busca)
    }


    render() {
        return(
            
            <div htmlFor="imputBusca" className="divBusca">
                <form onSubmit={this.buscar}>
                <input htmlFor="imputBusca" type="text" value={this.state.busca} className="txtBusca"
                onChange = {e=> this.setState({busca: e.target.value})} placeholder="O que você gostaria de aprender hoje ?"/>
                <img className="imgBusca" src={ImgBusca} onClick={this.buscar}/>
                </form>
            </div>

        )
    }

}

export default Busca