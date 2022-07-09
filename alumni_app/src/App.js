import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import RouteApp from './setup/routes-manager/RouteApp';
import Navbar from './common/Navbar';
import keycloak from './Keycloak';
import { ReactKeycloakProvider } from '@react-keycloak/web';

function App() {
  return (
    <ReactKeycloakProvider authClient={keycloak} initOptions= {{onload: 'login-required'}}>
    <BrowserRouter>
      <Navbar></Navbar>
      <div className='body-custom'>
        <RouteApp></RouteApp>
      </div>

    </BrowserRouter>
    </ReactKeycloakProvider>
  );
}

export default App;
