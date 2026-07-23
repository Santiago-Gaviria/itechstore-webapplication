const form = document.getElementById("productForm"); 
const messageDiv = document.getElementById("message");

form.addEventListener("submit", saveProduct);


function showMessage(msg, isError = false) {
  messageDiv.textContent = msg;
  messageDiv.style.display="block";
  if(isError){
    messageDiv.style.backgroundColor="#f80000";
    messageDiv.style.color="#ffffff";
  }else{
    messageDiv.style.backgroundColor="#82A903";
    messageDiv.style.color="#000000";
  }
  //messageDiv.style.color = isError ? "red" : "green";
}

async function saveProduct(event) {
  
  event.preventDefault();


  const name = document.getElementById("productName").value.trim();
  const price = document.getElementById("price").value.trim();
  const stock = document.getElementById("stock").value.trim(); 
  const categoryId = document.getElementById("categoryId").value.trim();


  if (!name || !price || !stock || !categoryId) {
    showMessage("All fields are required", true);
    return;
  }

  const productData = {
    productName: name,
    price: Number(price),
    stock: Number(stock),
    category: {
      id: Number(categoryId),
    },
  };

  try {
    const response = await fetch("http://localhost:8080/api/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(productData),
    });


    if (!response.ok) {
      throw new Error("The server declined the request");
    }

    showMessage("Product added successfully!");
    form.reset();
  } catch (error) {
    showMessage("Error: Verify if the ID exists or that the server is running", true);
    console.error(error);
  }

}
