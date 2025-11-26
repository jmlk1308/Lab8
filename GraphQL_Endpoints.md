#browser endpoint:
http://localhost:8080/graphiql

#API tester (Postman, Telend etc.):
http://localhost:8080/graphql



#Show all product query:
query {
    allProducts {
        name
        id
        price
    }
}

#Add:
mutation {
  addProduct(product: { name: "Webcam", price: 45.99 }) {
    id
    name
    price
  }
}

#Update:
mutation {
  updateProduct(id: "1", product: { name: "Gaming Laptop", price: 1500.00 }) {
    id
    name
    price
  }
}

#Delete:
mutation {
  deleteProduct(id: "2")
}
