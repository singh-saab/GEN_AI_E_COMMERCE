//give me react code using bootsrap css for navbar componant where Name of Brand is Ecommerce and has navitems like Home ,about,signup,login,cart
import React from "react";
import { Navbar, Nav, Container }
from "react-bootstrap";
import { Link } from "react-router-dom";


const Header = () => {
    return (
    <Navbar bg="dark" variant="dark" expand="lg" collapseOnSelect>
      <Container>
        <Navbar.Brand as={Link} to="/">
          Ecommerce
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto">
            <Nav.Link as={Link} to="/cart">
              <i className="fas fa-shopping-cart"></i> Cart
            </Nav.Link>
            <Nav.Link as={Link} to="/login">
              <i className="fas fa-user"></i> Sign In
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
;
export default Header;

