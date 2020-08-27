package entities;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class FolderController {

    private final FolderRepository repository;

    private final FolderModelAssembler assembler;

    FolderController(FolderRepository repository, FolderModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root
    @GetMapping("/folders")
    CollectionModel<EntityModel<Folder>> all() {

        List<EntityModel<Folder>> employees = repository.findAll().stream()
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(FolderController.class).all()).withSelfRel());
    }

    @PostMapping("/folders")
    ResponseEntity<?> newFolder(@RequestBody Folder newFolder) {
        EntityModel<Folder> entityModel = assembler.toModel(repository.save(newFolder));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // Single item
    @GetMapping("/folders/{id}")
    EntityModel<Folder> one(@PathVariable Long id) {

        Folder folder = repository.findById(id)
                                  .orElseThrow(() -> new FolderNotFoundException(id));

        return assembler.toModel(folder);
    }

    @PutMapping("/folders/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody Folder newFolder, @PathVariable Long id) {
        Folder updatedFolder = repository.findById(id)
                                           .map(folder -> {
                                                folder.setName(folder.getName());
                                                folder.setDescription(folder.getDescription());
                                                return repository.save(folder);
                                            })
                                          .orElseGet(() -> {
                                                newFolder.setId(id);
                                                return repository.save(newFolder);
                                            });

        EntityModel<Folder> entityModel = assembler.toModel(updatedFolder);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/folders/{id}")
    ResponseEntity<?> deleteFolder(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}