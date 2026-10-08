package ifgram.ifpb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static org.junit.jupiter.api.Assertions.*;

public record UserRequestTest(
        @Email
        String email,

        @Size(min=3)
        @NotNull
        String nome,

        @Size
        @NotNull
        String senha,
) {}