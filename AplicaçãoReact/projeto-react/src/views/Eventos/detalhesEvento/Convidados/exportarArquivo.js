import React from 'react';

import '../../css-evento.css';
import axios from 'axios';
//Serve para trabalhar com os mymes types, recomendo que pesquise um pouco sobre é interessante
import mime from 'mime-types';

export default function ExportarArquivo() {
    const id = localStorage.getItem("codigo");
    

    //Configuração padrão para o axios
    const config = {
        url: `http://localhost:8080/convidado/${id}`,
        method: 'GET',
        responseType: 'blob'
    };

    //função que fica responsável por buscar e salvar o arquivo, nesse casso uma imagem.
 function exportArquivo() {

        //Realizando chamada no endpoint
        axios(config).then(response => {
            response.blob().then(blob => {
                let url = window.URL.createObjectURL(blob);
                let a = document.createElement('a');
                a.href = url;
                a.download = 'lista.txt';
                a.click();
            });


/*

            //exibindo no console o objeto que esse endpoint retorna(para fins didáticos)
            console.log(response);

            //Criando um objeto do tipo URL
            const url = window.URL.createObjectURL(new Blob([response.data]));

            //Criando um novo elemento <a></a>
            const link = document.createElement('a');

            //Colocando o atributo href nele
            link.href = url;

            //colocando o atributo href no <a>, repare que estou usando uma lib para converter o myme type para uma extensão válida.
            //Note que deixei "mocado" o titulo do arquivo, e na sequencia concateno com "." e a resposta da conversão, isso evita deixar a extensão mocada.
            link.setAttribute('Lista_de_convidados', `pdf.${mime.extension(response.data.type)}`);

            //Colocando o <a> dentro do <body></body>
            document.body.append(link);

            //Forçando o click para que seja realizado o download
            link.click();
 */       })

    }


    return (
        <button onClick={() => exportArquivo()} className="botaoVoltar">Exportar Arquivo</button>
    );
}    const id = localStorage.getItem("codigo");


