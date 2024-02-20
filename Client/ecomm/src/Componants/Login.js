// Login.js
import React from 'react'
import styled from 'styled-components'

const FormContainer = styled.div`
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
`

const FormTitle = styled.h2`
  text-align: center;
  margin-bottom: 20px;
`

const Form = styled.form`
  display: flex;
  flex-direction: column;
`

const FormLabel = styled.label`
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
`

const FormInput = styled.input`
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
`

const FormButton = styled.button`
  background-color: #333;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
`

const Login = () => {
  const handleSubmit = (e) => {
    e.preventDefault()
    // Handle login logic here
  }

  return (
    <FormContainer>
      <FormTitle>Login</FormTitle>
      <Form onSubmit={handleSubmit}>
        <FormLabel>
          Email:
          <FormInput type='email' required />
        </FormLabel>
        <FormLabel>
          Password:
          <FormInput type='password' required />
        </FormLabel>
        <FormButton type='submit'>Login</FormButton>
      </Form>
    </FormContainer>
  )
}

export default Login
