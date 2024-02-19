import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from './components/common/Navbar';
import Footer from './components/common/Footer';
import Login from './components/auth/Login';
import Register from './components/auth/Register';
// import ForgotPassword from './components/auth/ForgotPassword';
// import ChangePassword from './components/auth/ChangePassword';
import Cart from './components/cart/Cart';
import Checkout from './components/cart/Checkout';
import ProductCatalog from './components/product/ProductCatalog';

const App = () => {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Switch>
          <Route exact path="/" component={ProductCatalog} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          {/* <Route path="/forgot-password" component={ForgotPassword} />
          <Route path="/change-password" component={ChangePassword} /> */}
          <Route path="/cart" component={Cart} />
          <Route path="/checkout" component={Checkout} />
        </Switch>
        <Footer />
      </div>
    </Router>
  );
};

export default App;
