window.addEventListener("load", function() {
	const addFile = document.querySelector("#addFile");

	addFile.addEventListener("click", function() {
		const tbody = document.querySelector("tbody");
		const tr = document.createElement("tr");
		const td = document.createElement("td");
		const p = document.createElement("p");
		const inputFile = document.createElement("input");
		const inputBtn = document.createElement("input");

		inputFile.type = "file";
		inputFile.name = "files";

		inputBtn.setAttribute("class", "btn btn-primary")
		inputBtn.type = "button"
		inputBtn.value = "취소";

		inputBtn.addEventListener("click", function() {
			this.parentNode.parentNode.parentNode.remove();
		})

		p.appendChild(inputFile);
		p.appendChild(inputBtn);
		td.appendChild(p);
		tr.appendChild(td);
		tbody.appendChild(tr);
	})

})
