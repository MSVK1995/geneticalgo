/**
 * @desc Chromosome is a set of genes. Multiple sets of chromosome make an individual  
 */
package src.population;

import java.util.ArrayList;
import java.util.List;

class Chromosome {
 
  // Chromosome is made of set of different genes 
  List<Gene> genes = new ArrayList<>();
 /** 
   * It is parametrized constructor that takes in length of chromosome and add new Genes to the list with random Gene values. 
   */
  Chromosome(int length) {
    for (int i = 0; i < length; i++) {
      genes.add(new Gene());
    }
  }

  
  /** 
   * @return List<Gene> this function returns the list of genes of a particular chromosome. 
   */
  public List<Gene> getGenes() {
    return genes;
  }

  
  /** 
   * @param geneIndex index of gene in chromosome list at which a new gene value needs to be assigned.
   * @param gene new gene who's value needs to be set to gene at geneIndex
   */
  public void addGene(int geneIndex, Gene gene) {
    this.genes.set(geneIndex, new Gene(gene.getValue()));
  }

  
  /** 
   * @desc Overriding of toString() function to print the value of Chromosome.
   * @return String 
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for(Gene g:genes) {
      stringBuilder.append(g.getEnumValue());
    }
    return stringBuilder.toString();
  }
}
