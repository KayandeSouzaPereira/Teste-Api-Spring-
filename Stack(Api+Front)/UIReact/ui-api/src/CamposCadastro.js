import React from 'react';
import ReactDOM from 'react-dom'


class Nome extends React.Component {
    render() {
        return (
          
            <table class="table table-bordered table-dark">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Data de Incrição</th>
                        <th scope="col">Ultima Atualização</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.Nome && this.props.Nome.map(Nomes => {
                        return <tr>
                            <td scope="row">{Nomes.Cadastro.Nome}</td>
                            <td scope="row">{Nomes.Cadastro.Descricao}</td>
                            <td scope="row">{Nomes.Cadastro.DataInscricao}</td>
                            <td scope="row">{Nomes.Cadastro.DataUpdate}</td>
                        </tr>
                    })}
                </tbody>
            </table>
        );
    }
}

class App1 extends React.Component {
    constructor(props) {
        super(props);
    this.state = {
      friends: [],
      name: '',
      descricao: '',
      DatadeInicio: ''
    };

    this.create = this.create.bind(this);
    this.update = this.update.bind(this);
    this.delete = this.delete.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

   componentDidMount() {
    fetch("http://localhost:8080/lista", {
      "method": "GET",
       "headers": {
      }
    })  
    .then(response => response.json())
    .then(data => {
      this.setState({ friends : [data] })})
         .catch(err => { console.log(err); 
         });
   }
   

  create(e) {
    e.preventDefault();

    fetch("http://localhost:8080/add", {
      "method": "POST",
      "headers": {
        "content-type": "application/json",
        "accept": "application/json"
      },
      "body": 
        this.state.name + "," + this.state.notes
    })
    .then(response => response.json())
    .then(response => {
      alert(response)
    })
    .catch(err => {
      console.log(err);
    });
  }

  update(e) {
    e.preventDefault();

    fetch("http://localhost:8080/update", {
        "method": "POST",
        "headers": {
            "content-type": "application/json",
            "accept": "application/json"
        },
        "body": 
        this.state.name + "," + this.state.notes
        })
        .then(response => response.json())
        .then(response => { alert(response);
        })
        .catch(err => { console.log(err); });
  }

  delete(e) {
    e.preventDefault();
    fetch(`http://localhost:8080/delete`, {
      "method": "POST",
      "headers": {
       },
       "body": 
       this.state.name + "," + this.state.notes
    })
    .then(response => response.json())
    .then(response => {alert(response);
    })
    .catch(err => {
      console.log(err);
    });
  }

  handleChange(changeObject) {
    this.setState(changeObject)
  }

  render() {
    return (
        
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-md-8">
              <form className="d-flex flex-column">
                <legend className="text-center">Adição-Update-Delete</legend>
                <label htmlFor="name">
                  Nome:
                  <input
                    name="name"
                    id="name"
                    type="text"
                    className="form-control"
                    value={this.state.name}
                    onChange={(e) => this.handleChange({ name: e.target.value })}
                    required
                    />
                </label>
                <label htmlFor="notes">
                  Descrição:
                  <input
                    name="notes"
                    id="notes"
                    type="test"
                    className="form-control"
                    value={this.state.notes}
                    onChange={(e) => this.handleChange({ notes: e.target.value })}
                    required
                    />
                </label>
                
                <button className="btn btn-primary" type='button' onClick={(e) => this.create(e)}>
                  Add
                </button>
                <button className="btn btn-info" type='button' onClick={(e) => this.update(e)}>
                    Update
                </button>
                <button className="btn btn-danger" type='button' onClick={(e) => this.delete(e)}>
                    Delete
                </button>
                <div><h1>Ultimo Cadastro</h1></div>
                <Nome Nome={this.state.friends} />
              </form>
            </div>
          </div>
        </div>
    );
  }
}

let domContainer = document.querySelector('#root');
ReactDOM.render(<App1/>, domContainer);
export default App1