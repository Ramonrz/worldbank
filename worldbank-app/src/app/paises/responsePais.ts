import { Paginacao } from '../models/paginacao';
import { Pais } from './pais';

export class ResponsePais {

    paginacao: Paginacao;
    paises: Pais[]; 
}
