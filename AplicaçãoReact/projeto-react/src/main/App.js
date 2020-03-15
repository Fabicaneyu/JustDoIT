import React from 'react';
import Rotas from './rotas'
import Navbar from '../components/navbar'

import 'bootswatch/dist/pulse/bootstrap.css'
import '../views/custom.css'

class App extends React.Component {


  render(){
    return (
      <>
      <div >
        <Navbar className="container"/>
        <Rotas/>
      </div>
      </>
    );
  }
}

export default App;
