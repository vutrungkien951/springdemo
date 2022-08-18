
function deleteProduct(endpoint, id, obj) {
    let d = document.getElementById("load" + id)
    d.style.display = "block";
    obj.style.display = "none";

    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
        if (res.status === 204)
        {
            let r = document.getElementById("row" + id);
            r.style.display = "none";
        }

    }).catch(function (err) {
        console.error(err)
    })
}

function loadProduct(endpoint){
    fetch(endpoint).then(function(res){
       return res.json(); 
    }).then(function(data) {
        console.info(data);
        let msg = "";
        for(let i=0; i < data.length; i++){
            msg += 
            `<tr>
                <td>${data[i].id}</td>
                <td>${data[i].name}</td>
                <td><img witdh=120 alt="Image" src="${data[i].image}"/></td>
                <td>${data[i].price}</td>
                <td>
                    <div style="display:block" id='div${data[i].id}'>ABC</div>
                    <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>
                    <button class="btn btn-danger" id="btn${data[i].id}" onclick="deleteProduct('${endpoint + "/" + data[i].id}', ${data[i].id})">Delete</button>
                </td>
            </tr>`;
        
        let d = document.getElementById("adminProd");
        d.innerHTML = msg;
        
        }
    });
}

