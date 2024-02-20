// Footer.js
import React from 'react'
import styled from 'styled-components'

const FooterContainer = styled.footer`
  background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;
  position: fixed;
  bottom: 0;
  width: 100%;
`

const Footer = () => {
  return (
    <FooterContainer>
      &copy; 2024 My Ecommerce. All rights reserved.
    </FooterContainer>
  )
}

export default Footer
