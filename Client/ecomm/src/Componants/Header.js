// Header.js
import React from 'react'
import { Link } from 'react-router-dom'
import styled from 'styled-components'

const HeaderContainer = styled.header`
  display: flex;
  background-color: #333;
  color: #fff;
  padding: 20px;

`

const Logo = styled.div`
  font-size: 24px;
  font-weight: bold;
`

const Navigation = styled.nav`
  display: flex;
  justify-content: space-between;
`

const MenuItem = styled(Link)`
  color: #fff;
  text-decoration: none;
  margin-left: 20px;
  &:first-child {
    margin-left: 0;
  }
`

const Header = () => {
  return (
    <HeaderContainer>
      <MenuItem href='/'>
      <Logo>My Ecommerce</Logo>
      </MenuItem>
      <div style={{ marginLeft: 'auto' }}>
        <Navigation>
          <MenuItem to="/">Home</MenuItem>
          <MenuItem to="/products">Products</MenuItem>
          <MenuItem to="/contact">Contact</MenuItem>
          <MenuItem to="register">Register</MenuItem>
          <MenuItem to="/login">Login</MenuItem>
          <MenuItem to="/cart">Cart</MenuItem>

        </Navigation>
      </div>
    </HeaderContainer>
  )
}

export default Header
