import React from 'react'

class Busca extends React.Component {

    state = {

        busca: ''

    }


    buscar = () => {
        console.log(this.state.busca)
    }


    render() {
        return (

            <div htmlFor="imputBusca" className="col-md-6 col-sm-10 col-10">
                <form onSubmit={this.buscar}>
                    <input className="form-control mr-sm-2" type="search" value={this.state.busca} 
                        onChange={e => this.setState({ busca: e.target.value })} placeholder="O que você gostaria de aprender hoje ?" />
                    
                </form>
            </div>
            // <img className="imgBusca" src={ImgBusca} onClick={this.buscar} />


        )
    }

}

export default Busca