import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Pais } from '../pais';
import { PaisService } from '../pais.service';

@Component({
  selector: 'app-lista-paises',
  templateUrl: './lista-paises.component.html',
  styleUrls: ['./lista-paises.component.css']
})
export class ListaPaisesComponent implements OnInit {

  registros: number;
  displayedColumns: string[] = ['id', 'codigoPais', 'pais', 'capital'];
  dataSource = new MatTableDataSource<Pais>();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private paisService: PaisService) { }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.getPaises(1);
  }

  getPaises(pagina: number) {
    this.paisService.consultarPaises(pagina).subscribe(data => {
      this.dataSource.data = data.paises;
      this.registros = data.paginacao.registros;
    });

  }

  handlePage(e: any) {
    this.getPaises(e.pageIndex + 1);
    this.paginator.pageIndex = e.pageIndex;
  }

}
