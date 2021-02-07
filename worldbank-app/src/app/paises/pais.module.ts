import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AppRoutingModule } from '../app-routing.module';
import { ListaPaisesComponent } from './lista-paises/lista-paises.component';
import { PaisService } from './pais.service';

@NgModule({
    declarations: [ListaPaisesComponent],
    imports: [
        CommonModule,
        MatIconModule,
        MatTableModule,
        AppRoutingModule,
        MatToolbarModule,
        MatPaginatorModule
    ],
    providers: [PaisService],
})
export class PaisModule { }
