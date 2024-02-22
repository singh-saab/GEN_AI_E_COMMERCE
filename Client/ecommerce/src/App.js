import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from './components/common/Navbar';
import Footer from './components/common/Footer';
import Login from './components/auth/Login';
import Register from './components/auth/Register';
import Hero from './components/Hero';
// import ForgotPassword from './components/auth/ForgotPassword';
// import ChangePassword from './components/auth/ChangePassword';
import Cart from './components/cart/Cart';
import Checkout from './components/cart/Checkout';
import ProductCatalog from './components/product/ProductCatalog';
import './App.css';
import Header from './components/common/Header';

const App = () => {
  return (
    <Router>
      <div className="App">
        <Header/>
      </div>
    </Router>
  );
};

export default App;






