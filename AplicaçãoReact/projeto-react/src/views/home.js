import React from 'react'
import Navbar from '../components/navbar'
import UserInfo from '../components/infoUserBar'
import {withRouter} from 'react-router-dom'
import axios from 'axios'

class Home extends React.Component {

    state = {
        nome: ''
    }

    componentDidMount(){
        axios.get('http://localhost:8080/user/name')
        .then( response => {
            this.setState({nome: response.data})
        }).catch(error => {
            console.error(error.response)
        });
    }

    render() {


        return(
            <>
            <Navbar className="container"/>
            <UserInfo label={this.state.nome} />
            </>
        )

    }


}

export default Home