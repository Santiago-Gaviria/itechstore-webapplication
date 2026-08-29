// URL de tu API en Spring Boot
const API_URL = "http://localhost:8080/api/products";



// Load products to the Data Base (GET)

async function loadProducts() {
    try {
        const response = await fetch(API_URL);
        
        if (!response.ok) {
            throw new Error("Failed to fetch products");
        }

        const products = await response.json();
        const tableBody = document.getElementById("tableBody");
        

        // Limpia la tabla antes de llenarla
        tableBody.innerHTML = ""; 

        products.forEach(product => {
            const row = document.createElement("tr");
            
            // Verificamos el ID de la categoría
            const categoryId = product.category ? product.category.id : 'N/A';
            
            row.innerHTML = `
                <td style="color: var(--text-muted);">#100${product.id}</td>
                <td>${product.productName}</td>
                <td>$${product.price}</td>
                <td>${product.stock}</td>
                <td>
                    <span class="status-pill">Cat ${categoryId}</span>
                </td>
                <td>
                    <!-- ✨ EL NUEVO BOTÓN DE ELIMINAR -->
                    <button onclick="deleteProduct(${product.id})" style="background: none; border: none; cursor: pointer; font-size: 1.2rem;" title="Delete">🗑️</button>
                </td>
            `;
            
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error("Error loading products:", error);
    }
}


//Save a new product (POST)

document.getElementById("productForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // Evita que recargue la página

    const productName = document.getElementById("productName").value;
    const price = document.getElementById("price").value;
    const stock = document.getElementById("stock").value;
    const categoryId = document.getElementById("categoryId").value;

    const productData = {
        productName: productName,
        price: parseFloat(price),
        stock: parseInt(stock),
        category: {
            id: parseInt(categoryId)
        }
    };

    const messageDiv = document.getElementById("message");

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(productData)
        });

        if (response.ok) {
            // Estilos de éxito
            messageDiv.style.display = "block";
            messageDiv.style.backgroundColor = "rgba(228, 255, 26, 0.15)";
            messageDiv.style.color = "var(--neon)";
            messageDiv.innerText = "Product saved successfully!";
            
            document.getElementById("productForm").reset(); // Limpia los inputs
            loadProducts(); // <--- RECARGA LA TABLA AL INSTANTE
            
            setTimeout(() => messageDiv.style.display = "none", 3000);
        } else {
            throw new Error("Failed to save product");
        }
    } catch (error) {
        // Estilos de error
        messageDiv.style.display = "block";
        messageDiv.style.backgroundColor = "rgba(255, 0, 0, 0.15)";
        messageDiv.style.color = "#ff4444";
        messageDiv.innerText = "Error: Check Category ID.";
        console.error("Error:", error);
    }
});

// ==========================================
// 3. INICIALIZAR
// ==========================================
// Ejecuta loadProducts() automáticamente al abrir la página
document.addEventListener("DOMContentLoaded", loadProducts);
// ==========================================
// 4. ELIMINAR UN PRODUCTO (DELETE)
// ==========================================
async function deleteProduct(id) {
    // 1. Confirmación de seguridad
    const isConfirmed = confirm("Are you sure you want to delete this product?");
    
    if (!isConfirmed) {
        return; 
    }

    try {
        // 2. Enviamos la petición DELETE a Java
        const response = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (response.ok) {
            // 3. ¡Leemos el String que retorna tu ProductController!
            const backendMessage = await response.text(); 
            
            // 4. Mostramos tu mensaje y recargamos la tabla
            alert(backendMessage); 
            loadProducts();
            
        } else {
            throw new Error("Failed to delete product");
        }
    } catch (error) {
        console.error("Error deleting product:", error);
        alert("There was an error deleting the product.");
    }
    async function deleteProduct(id) {
    const isConfirmed = confirm("Are you sure you want to delete this product?");
    
    if (!isConfirmed) return;

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (response.ok) {
            const backendMessage = await response.text(); 
            alert(backendMessage); // Muestra el mensaje que configuraste en Spring Boot
            loadProducts(); // Recarga la tabla
        } else {
            throw new Error("Failed to delete product");
        }
    } catch (error) {
        console.error("Error deleting product:", error);
        alert("Error deleting the product.");
    }
}
}