// Header.js
import React from 'react'
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

const MenuItem = styled.a`
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
          <MenuItem href='/'>Home</MenuItem>
          <MenuItem href='/Products'>Products</MenuItem>
          <MenuItem href='#'>Contact</MenuItem>
          <MenuItem href='/Register'>Register</MenuItem>
          <MenuItem href='/Login'>Login</MenuItem>
          <MenuItem href='/cart'>Cart</MenuItem>
        </Navigation>
      </div>
    </HeaderContainer>
  )
}

export default Header
